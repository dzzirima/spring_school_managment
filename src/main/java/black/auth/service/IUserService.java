package black.auth.service;

import black.auth.entity.UserEntity;
import black.auth.model.User;

public interface IUserService {
    User registerUser(User user);
}
