CREATE TABLE IF NOT EXISTS `page` (
  `id` bigint(20) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `site_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `site` (
  `id` bigint(20) NOT NULL,
  `host` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `page` ADD PRIMARY KEY (`id`), ADD KEY `FK_kd6kutdujd8x9c9cft9l26hbu` (`site_id`);
ALTER TABLE `site` ADD PRIMARY KEY (`id`);
ALTER TABLE `page` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
ALTER TABLE `site` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
ALTER TABLE `page` ADD CONSTRAINT `FK_kd6kutdujd8x9c9cft9l26hbu` FOREIGN KEY (`site_id`) REFERENCES `site` (`id`);