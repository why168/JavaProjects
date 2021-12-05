package com.github.why168;

/**
 * @author Edwin.Wu edwin.wu05@gmail.com
 * @version 2020/2/27 4:29 下午
 * @since JDK1.8
 */
public class Test2Main {

    public static void main(String[] args) {
        String location = "/user/social/comment_add,/user/social/like,/user/social/del,/user/social/comment_head,/user/social/comment_list,/user/social/feed_like_list,/user/social/like_entity_list,/user/social/beliked_nums,/user/social/share,/user/social/view,/user/social/get_comments,/user/social/add_num,/user/social/comment_info,/user/social/get_num,/user/social/like_status,/user/social/mget_child_comments,/user/social/operation_get_uid_like_count";
        String logResponse = "false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false";

        String[] locations = location.split(",");
        String[] logResponses = logResponse.split(",");
        if (locations.length == logResponses.length) {

            for (int i = 0; i < locations.length; i++) {
                System.out.println(locations[i] + " , " + logResponses[i]);
            }
        }
    }

}
