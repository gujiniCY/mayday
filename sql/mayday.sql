
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mayday_article
-- ----------------------------
DROP TABLE IF EXISTS `mayday_article`;
CREATE TABLE `mayday_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '发表用户',
  `article_content` longtext COMMENT '文章内容html格式',
  `article_content_md` longtext COMMENT '文章内容Markdown格式',
  `article_newstime` datetime DEFAULT NULL COMMENT '发布时间',
  `article_status` int(11) DEFAULT NULL COMMENT '文章状态 0已发布1草稿2回收站',
  `article_summary` varchar(255) DEFAULT NULL COMMENT '文章摘要',
  `article_thumbnail` varchar(255) DEFAULT NULL COMMENT '略缩图',
  `article_title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `article_type` int(255) DEFAULT NULL COMMENT '文章类型0原创1转载',
  `article_post` varchar(255) DEFAULT NULL COMMENT 'post文章 page页面',
  `article_comment` int(11) DEFAULT NULL COMMENT '是否开启评论 0开启1不开启',
  `article_updatetime` datetime DEFAULT NULL COMMENT '文章最后修改时间',
  `article_url` varchar(255) DEFAULT NULL COMMENT '文章路径',
  `article_views` bigint(20) DEFAULT '0' COMMENT '访问量统计',
  PRIMARY KEY (`id`),
  UNIQUE KEY `MAYDAY_ARTICLE_URL` (`article_url`) USING BTREE,
  KEY `MAYDAY_ARTICLE_USERID` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_article_category
-- ----------------------------
DROP TABLE IF EXISTS `mayday_article_category`;
CREATE TABLE `mayday_article_category` (
  `article_id` int(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  KEY `MAYDAY_ARTILE_ID` (`article_id`) USING BTREE,
  KEY `MAYDAY_ARTILE_CATEGORY_ID` (`category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `mayday_article_tag`;
CREATE TABLE `mayday_article_tag` (
  `article_id` int(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  KEY `MAYDAY_ARTILE_ID` (`article_id`) USING BTREE,
  KEY `MAYDAY_ARTILE_TAG_ID` (`tag_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_attachment
-- ----------------------------
DROP TABLE IF EXISTS `mayday_attachment`;
CREATE TABLE `mayday_attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `picture_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `picture_path` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `picture_small_path` varchar(255) DEFAULT NULL COMMENT '略缩图',
  `picture_type` varchar(255) DEFAULT NULL COMMENT '图片类型',
  `picture_create_date` varchar(255) DEFAULT NULL COMMENT '上传时间',
  `picture_size` varchar(255) DEFAULT NULL COMMENT '文件大小',
  `picture_suffix` varchar(255) DEFAULT NULL COMMENT '后缀',
  `picture_wh` varchar(255) DEFAULT NULL COMMENT '尺寸',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_category
-- ----------------------------
DROP TABLE IF EXISTS `mayday_category`;
CREATE TABLE `mayday_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `category_url` varchar(255) DEFAULT NULL COMMENT '分类路径',
  `category_describe` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_link
-- ----------------------------
DROP TABLE IF EXISTS `mayday_link`;
CREATE TABLE `mayday_link` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `link_url` varchar(255) DEFAULT NULL COMMENT '路径',
  `link_logo` varchar(255) DEFAULT NULL COMMENT '链接logo',
  `link_describe` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_logs
-- ----------------------------
DROP TABLE IF EXISTS `mayday_logs`;
CREATE TABLE `mayday_logs` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `log_content` varchar(255) DEFAULT NULL COMMENT '内容',
  `log_ip` varchar(255) DEFAULT NULL COMMENT 'ip',
  `log_date` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=892 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_menu
-- ----------------------------
DROP TABLE IF EXISTS `mayday_menu`;
CREATE TABLE `mayday_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_sort` int(11) DEFAULT NULL COMMENT '排序',
  `menu_target` varchar(255) DEFAULT NULL COMMENT '打开方式',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单路径',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_options
-- ----------------------------
DROP TABLE IF EXISTS `mayday_options`;
CREATE TABLE `mayday_options` (
  `option_name` varchar(255) NOT NULL COMMENT '设置名',
  `option_value` longtext COMMENT '设置内容',
  PRIMARY KEY (`option_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_tag
-- ----------------------------
DROP TABLE IF EXISTS `mayday_tag`;
CREATE TABLE `mayday_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) DEFAULT NULL COMMENT '标签名称',
  `tag_url` varchar(255) DEFAULT NULL COMMENT '标签路径',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_theme
-- ----------------------------
DROP TABLE IF EXISTS `mayday_theme`;
CREATE TABLE `mayday_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme_name` varchar(255) DEFAULT NULL COMMENT '主题名(url)',
  `theme_describe` varchar(255) DEFAULT NULL COMMENT '主题描述',
  `theme_img` varchar(255) DEFAULT NULL COMMENT '主题预览图',
  `theme_status` int(11) DEFAULT '0' COMMENT '0未启用1已启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mayday_user
-- ----------------------------
DROP TABLE IF EXISTS `mayday_user`;
CREATE TABLE `mayday_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_enable` varchar(255) DEFAULT '0' COMMENT '是否禁用登录',
  `login_error` int(11) DEFAULT NULL COMMENT '登录失败次数',
  `login_last_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `user_portrait` varchar(255) DEFAULT NULL COMMENT '头像',
  `user_explain` varchar(255) DEFAULT NULL COMMENT '说明',
  `user_display_name` varchar(255) DEFAULT NULL COMMENT '显示名称',
  `user_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
