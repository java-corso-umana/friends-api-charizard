package org.friends.api.shared.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteUserDto {
    private String username;
}
