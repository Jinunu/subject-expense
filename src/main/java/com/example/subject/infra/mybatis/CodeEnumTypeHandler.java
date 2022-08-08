package com.example.subject.infra.mybatis;

import com.example.subject.domain.CodeEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class CodeEnumTypeHandler<E extends Enum<E>> implements TypeHandler<CodeEnum> {
    private Class<E> type;

    public CodeEnumTypeHandler(Class<E> type) {
        this.type = type;
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, CodeEnum codeEnum, JdbcType jdbcType) throws
            SQLException {
        preparedStatement.setInt(i, codeEnum.getCode());
    }

    @Override
    public CodeEnum getResult(ResultSet resultSet, String s) throws SQLException {
        return getCodeEnum(resultSet.getInt(s));
    }

    @Override
    public CodeEnum getResult(ResultSet resultSet, int i) throws SQLException {
        return getCodeEnum(resultSet.getInt(i));
    }

    @Override
    public CodeEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        return getCodeEnum(callableStatement.getInt(i));
    }

    private CodeEnum getCodeEnum(int code) {
        try {
            CodeEnum[] enumConstants = (CodeEnum[])type.getEnumConstants();
            return Arrays.stream(enumConstants)
                    .filter(codeEnum -> code == codeEnum.getCode())
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new TypeException(new StringBuilder("Can't make enum object '")
                    .append(type)
                    .append("'\n")
                    .append(e)
                    .toString());
        }
    }
}