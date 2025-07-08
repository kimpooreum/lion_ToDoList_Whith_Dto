package org.poopoo.to_do_list_with_dto.mdel;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails.Node;

@Data
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
}
