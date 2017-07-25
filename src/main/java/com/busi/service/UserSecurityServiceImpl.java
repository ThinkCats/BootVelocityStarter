package com.busi.service;

import com.busi.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hehe on 2017/7/25.
 */
@Slf4j
@Service
public class UserSecurityServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private GroupMembersRepository groupMembersRepository;
    @Autowired
    private GroupsRepository groupsRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        log.info("load user info:{}", name);
        Users user = usersRepository.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GroupMembers> groupMembersList = groupMembersRepository.findByUsername(name);
        List<Long> groupIds = new ArrayList<>();
        for (GroupMembers groupMember : groupMembersList) {
            groupIds.add(groupMember.getGroupId());
        }
        List<Groups> groupsList = groupsRepository.findByIdIn(groupIds);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Groups group : groupsList) {
            log.info("group name:{}", group.getGroupName());
            authorities.add(new SimpleGrantedAuthority(group.getGroupName()));
        }
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
