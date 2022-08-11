INSERT INTO expense(expense_id, use_date, expense, reg_date, usage_type, processing_date, processing_state, approval_expense, message)
VALUES (1, '2022-08-01', 3000, '2022-08-02', '0', NULL, '0', 3000, NULL);
INSERT INTO expense(expense_id, use_date, expense, reg_date, usage_type, processing_date, processing_state, approval_expense, message)
VALUES (2, '2022-08-02', 3000, '2022-08-03', '1', NULL, '1', 3000, NULL);
INSERT INTO expense(expense_id, use_date, expense, reg_date, usage_type, processing_date, processing_state, approval_expense, message)
VALUES (3, '2022-08-03', 3000, '2022-08-04', '2', NULL, '2', 3000, NULL);
INSERT INTO expense(expense_id, use_date, expense, reg_date, usage_type, processing_date, processing_state, approval_expense, message)
VALUES (4, '2022-08-04', 3000, '2022-08-05', '3', NULL, '3', 3000, NULL);
INSERT INTO expense(expense_id, use_date, expense, reg_date, usage_type, processing_date, processing_state, approval_expense, message)
VALUES (5, '2022-08-05', 3000, '2022-08-06', '4', NULL, '3', 3000, NULL);

INSERT INTO file(expense_id, file_name, original_name) values (1, '파일이름', '원래이름');