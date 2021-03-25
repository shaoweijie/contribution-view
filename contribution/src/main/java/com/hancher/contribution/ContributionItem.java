package com.hancher.contribution;

import java.util.Date;

/**
 * 作者 : Hancher ytu_shaoweijie@163.com <br/>
 * 时间 : 2021/3/24 13:53 <br/>
 * 描述 : 一个方格
 */
public class ContributionItem {

    private Date time;
    private int number;
    private int row;
    private int col;

    public ContributionItem(Date time, int number) {
        this.time = time;
        this.number = number;
    }

    public Date getTime() {
        return time;
    }

    public ContributionItem setTime(Date time) {
        this.time = time;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public ContributionItem setNumber(int number) {
        this.number = number;
        return this;
    }

    public int getRow() {
        return row;
    }

    public ContributionItem setRow(int row) {
        this.row = row;
        return this;
    }

    public int getCol() {
        return col;
    }

    public ContributionItem setCol(int col) {
        this.col = col;
        return this;
    }
}
