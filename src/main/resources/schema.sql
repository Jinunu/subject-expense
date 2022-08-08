DROP TABLE IF EXISTS `expense`;

CREATE TABLE `expense` (
                           `expense_id`	BIGINT	NOT NULL AUTO_INCREMENT,
                           `use_date`	Date	NULL,
                           `expense`	int	NULL,
                           `reg_date`	Date	NULL,
                           `usage_type`	int	NULL,
                           `processing_state`	int	DEFAULT 0,
                           `processing_date`	Date	NULL,
                           `approval_expense`	int	NULL,
                           `message`	VARCHAR	NULL

);

ALTER TABLE `expense` ADD CONSTRAINT `PK_EXPENSE` PRIMARY KEY (
                                                               `expense_id`
    );

