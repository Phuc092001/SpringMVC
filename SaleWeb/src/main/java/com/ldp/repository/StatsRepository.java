/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldp.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface StatsRepository {
    List<Object[]> statsCategory();

    List<Object[]> statsRevenue(Date fromDate, Date toDate);
}
