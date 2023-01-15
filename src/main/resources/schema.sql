CREATE TABLE IF NOT EXISTS `orders` (
  `id` INT NOT NULL UNIQUE,
  `request_id` varchar(255) NOT NULL,
  `user_id` INT DEFAULT NULL,
  `ff_order_id` INT DEFAULT NULL,
  `coupon_code` varchar(255) DEFAULT NULL,
  `email_encrypted` varchar(255) NOT NULL,
  `mobile_encrypted` varchar(255) NOT NULL,
  `pg_amount` decimal(15,2) DEFAULT NULL,
  `pg_url` varchar(255) DEFAULT NULL,
  `fulfillment_service_id` INT NOT NULL,
  `external_user_id` varchar(255) DEFAULT NULL,
  `user_email_encrypted` varchar(255) DEFAULT NULL
);