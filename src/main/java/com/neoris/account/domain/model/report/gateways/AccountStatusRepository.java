package com.neoris.account.domain.model.report.gateways;

import com.neoris.account.domain.model.report.AccountStatusReport;
import com.neoris.account.domain.model.report.AccountStatusReportFilter;

import java.util.List;


public interface AccountStatusRepository {

    List<AccountStatusReport> getReportAccountStatus(AccountStatusReportFilter filter);
}
