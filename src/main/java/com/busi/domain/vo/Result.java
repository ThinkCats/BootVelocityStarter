package com.busi.domain.vo;

import com.souche.tangeche.comment.Comment;
import lombok.Data;

/**
 * @author WangLei
 * on 2018/2/9
 */
@Data
@Comment("Result通用结构")
public class Result {
    @Comment("是否成功")
    private boolean success;
    @Comment("描述信息")
    private String msg;

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static Result success(String msg) {
        return new Result(true, msg);
    }

}
