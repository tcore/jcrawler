ALTER TABLE `page` ADD UNIQUE(`site_id`, `path`);
ALTER TABLE `site` ADD UNIQUE(`host`);