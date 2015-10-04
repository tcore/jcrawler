ALTER TABLE `page` ADD `date_last_parsed` DATE DEFAULT NULL AFTER `site_id`;
ALTER TABLE `page` ADD `date_created` DATE NOT NULL AFTER `date_last_parsed`;