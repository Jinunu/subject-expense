package com.example.subject.util;

import com.example.subject.dto.ExpenseSearchResult;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ExpenseExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ExpenseSearchResult> results;


    public ExpenseExcelExporter(List<ExpenseSearchResult> results) {
        this.results = results;
        this.workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Expense");

        Row row = sheet.createRow(0);

        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "순번", style);
        createCell(row, 1, "사용일", style);
        createCell(row, 2, "사용내역", style);
        createCell(row, 3, "사용금액", style);
        createCell(row, 4, "승인금액", style);
        createCell(row, 5, "처리상태", style);
        createCell(row, 6, "등록일", style);
        //TODO Date 처리 ?LocalDate
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Long) {
            cell.setCellValue(((Long) value).longValue());
        } else if (value instanceof Boolean) {

            cell.setCellValue((Boolean) value);
        } else if (value instanceof LocalDate) {
            cell.setCellValue((LocalDate) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (ExpenseSearchResult reulst : results) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, reulst.getExpenseId(), style);
            createCell(row, columnCount++, reulst.getUseDate(), style);
            createCell(row, columnCount++, reulst.getUsageType().getTitle(), style);
            createCell(row, columnCount++, reulst.getExpense(), style);
            createCell(row, columnCount++, reulst.getApprovalExpense(), style);
            createCell(row, columnCount++, reulst.getProcessingState().getTitle(), style);
            createCell(row, columnCount++, reulst.getRegDate(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
