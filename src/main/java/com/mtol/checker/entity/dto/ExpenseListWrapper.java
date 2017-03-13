package com.mtol.checker.entity.dto;

import java.util.List;

/**
 * This is Expense list wrapper
 */
public class ExpenseListWrapper {

    private List<ExpenseDTO> data;

    public List<ExpenseDTO> getData() {
        return data;
    }

    public void setData(List<ExpenseDTO> data) {
        this.data = data;
    }
}
