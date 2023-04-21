package com.neoris.account.domain.usecase.report;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.report.AccountStatusReport;
import com.neoris.account.domain.model.report.AccountStatusReportFilter;
import com.neoris.account.domain.model.report.gateways.AccountStatusRepository;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class ReportUseCase {

    private final AccountStatusRepository accountStatusRepository;

    public List<AccountStatusReport> getReport(AccountStatusReportFilter filter){
        return accountStatusRepository.getReportAccountStatus(filter);
    }
}

