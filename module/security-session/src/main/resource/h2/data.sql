-- admin/admin
insert into users(username,password,enabled) values( 'admin', '$2a$10$BrpHlhYyofs0RSA72JXHxucWRSlHhqyPSdsfqqyY1DSUq5vEWDOH.', true);
-- user/user
insert into users(username,password,enabled) values( 'user', '$2a$10$wBkWTgqlprm1xJCroQo80..KVo.X.gJEgifddua6BSopY7RHVcB0i', true);

insert into authorities (username,authority) values('admin','ROLE_ADMIN');
insert into authorities (username,authority) values('user','ROLE_USER');
