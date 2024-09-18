INSERT INTO module (base_path,name) VALUES
                                                       ('/products','PRODUCT'),
                                                       ('/categories','CATEGORY'),
                                                       ('/customers','CUSTOMER'),
                                                       ('/auth','AUTH'),
                                                       ('/roles','ROLE'),
                                                       ('/operations','OPERATION');


INSERT INTO operation (http_method,name,`path`,permit_all,module_id) VALUES
                                                                                        ('GET','READ_ALL_PRODUCTS','',0,1),
                                                                                        ('GET','READ_ONE_PRODUCT','/[0-9]*',0,1),
                                                                                        ('POST','CREATE_ONE_PRODUCT','',1,1),
                                                                                        ('PUT','UPDATE_ONE_PRODUCT','/[0-9]*',0,1),
                                                                                        ('PUT','DISABLE_ONE_PRODUCT','/[0-9]*/disabled',0,1),
                                                                                        ('GET','READ_ALL_CATEGORIES','',0,2),
                                                                                        ('GET','READ_ONE_CATEGORY','/[0-9]*',0,2),
                                                                                        ('POST','CREATE_ONE_CATEGORY','',0,2),
                                                                                        ('PUT','UPDATE_ONE_CATEGORY','/[0-9]*',0,2),
                                                                                        ('PUT','DISABLE_ONE_CATEGORY','/[0-9]*/disabled',0,2);
INSERT INTO operation (http_method,name,`path`,permit_all,module_id) VALUES
                                                                                        ('GET','READ_ALL_CUSTOMERS','',0,3),
                                                                                        ('POST','REGISTER_ONE','',1,3),
                                                                                        ('POST','AUTHENTICATE','/authenticate',1,4),
                                                                                        ('GET','VALIDATE-TOKEN','/validate-token',1,4),
                                                                                        ('GET','READ_MY_PROFILE','/profile',0,4),
                                                                                        ('GET','READ_ALL_ROLES','',1,5),
                                                                                        ('GET','READ_ONE_ROLE','/[0-9]*',1,5),
                                                                                        ('POST','CREATED_ROLE','',1,5),
                                                                                        ('PUT','UPDATE_ROLE','/[0-9]*',1,5),
                                                                                        ('GET','GET_ALL_OPERATION','',1,6);
INSERT INTO operation (http_method,name,`path`,permit_all,module_id) VALUES
                                                                                        ('DELETE','DELETE_ROLE','/[0-9]*',1,5),
                                                                                        ('POST','LOGOUT','/logout',1,4),
                                                                                        ('POST','REFRESH_TOKEN','/refreshToken',1,4);


INSERT INTO role (name) VALUES
                                             ('USER'),
                                             ('ASSISTANT_ADMINISTRATOR'),
                                             ('ADMINISTRATOR');



INSERT INTO granted_permission (operation_id,role_id) VALUES
                                                                         (2,2),
                                                                         (4,2),
                                                                         (6,2),
                                                                         (7,2),
                                                                         (9,2),
                                                                         (15,2),
                                                                         (1,2),
                                                                         (2,2),
                                                                         (2,2),
                                                                         (4,2);
INSERT INTO granted_permission (operation_id,role_id) VALUES
                                                                         (6,2),
                                                                         (7,2),
                                                                         (9,2),
                                                                         (15,2),
                                                                         (1,3),
                                                                         (2,3),
                                                                         (3,3),
                                                                         (4,3),
                                                                         (5,3),
                                                                         (6,3);
INSERT INTO granted_permission (operation_id,role_id) VALUES
                                                                         (7,3),
                                                                         (8,3),
                                                                         (9,3),
                                                                         (10,3),
                                                                         (15,3),
                                                                         (1,2),
                                                                         (2,2);



INSERT INTO user (name,password,username,role_id) VALUES
                                                                       ('luis márquez','$2a$10$ywh1O2EwghHmFIMGeHgsx.9lMw5IXpg4jafeFS.Oi6nFv0181gHli','lmarquez',3),
                                                                       ('fulano pérez','$2a$10$V29z7/qC9wpHfzRMxGOHye5RMAxCid2/MzJalk0dsiA3zZ9CJfub.','fperez',2),
                                                                       ('mengano hernández','$2a$10$TMbMuEZ8utU5iq8MOoxpmOc6QWQuYuwgx1xJF8lSMNkKP3hIrwYFG','mhernandez',2),
                                                                       ('pepe juan','$2a$10$MgUGx/7cMsGwrLjJPx8HIe0bXhjqUxCRhqhuKGXknrFCUnkUkRVwu','pepe01',1);
