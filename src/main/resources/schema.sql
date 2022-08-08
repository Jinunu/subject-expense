DROP TABLE IF EXISTS `expense`;

CREATE TABLE `expense` (
                           `expense_id`	BIGINT	NOT NULL,
                           `use_date`	Date	NULL,
                           `expense`	int	NULL,
                           `reg_date`	Date	NULL,
                           `usage_type`	int	NOT NULL,
                           `processing_state`	int	NULL
);

DROP TABLE IF EXISTS `processing_history`;

CREATE TABLE `processing_history` (
                                      `processing_history_no`	BIGINT	NOT NULL,
                                      `expense_id`	BIGINT	NOT NULL,
                                      `processing_date`	Date	NULL,
                                      `approval_expense`	int	NULL,
                                      `message`	VARCHAR	NULL
);

ALTER TABLE `expense` ADD CONSTRAINT `PK_EXPENSE` PRIMARY KEY (
                                                               `expense_id`
    );

ALTER TABLE `processing_history` ADD CONSTRAINT `PK_PROCESSING_HISTORY` PRIMARY KEY (
                                                                                     `processing_history_no`,
                                                                                     `expense_id`
    );

ALTER TABLE `processing_history` ADD CONSTRAINT `FK_expense_TO_processing_history_1` FOREIGN KEY (
                                                                                                  `expense_id`
    )
    REFERENCES `expense` (
                          `expense_id`
        );

