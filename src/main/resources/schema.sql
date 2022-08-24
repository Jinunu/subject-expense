DROP TABLE IF EXISTS `expense`;
DROP TABLE IF EXISTS `file`;

CREATE TABLE `member` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR (255) unique NOT NULL,
    `password` VARCHAR (255) NOT NULL

);

CREATE TABLE `expense` (
                           `expense_id`	BIGINT	NOT NULL AUTO_INCREMENT,
                           `use_date`	Date	NULL,
                           `expense`	int	NULL,
                           `reg_date`	Date	NULL,
                           `usage_type`	VARCHAR (255)	NULL,
                           `processing_state`	VARCHAR (255)	DEFAULT '0',
                           `processing_date`	datetime	NULL,
                           `approval_expense`	int	NULL,
                           `message`	VARCHAR	NULL

);

CREATE TABLE `file` (
                        `file_id`	BIGINT	NOT NULL AUTO_INCREMENT,
                        `expense_id`	BIGINT	NOT NULL,
                        `original_name`	VARCHAR(255)	NULL,
                        `file_name`	VARCHAR(255)	NULL
);

ALTER TABLE `expense` ADD CONSTRAINT `PK_EXPENSE` PRIMARY KEY (
                                                               `expense_id`
    );

ALTER TABLE `file` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
                                                         `file_id`,
                                                         `expense_id`
    );

ALTER TABLE `file` ADD CONSTRAINT `FK_expense_TO_file_1` FOREIGN KEY (
                                                                      `expense_id`
    )
    REFERENCES `expense` (
                          `expense_id`
        )ON DELETE CASCADE;

