package com.neoris.account.infrastructure.driven_adapters.jpa_repository.report.account_status;

import com.neoris.account.domain.model.report.AccountStatusReport;
import com.neoris.account.domain.model.report.AccountStatusReportFilter;
import com.neoris.account.domain.model.report.gateways.AccountStatusRepository;
import com.neoris.account.infrastructure.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountStatusRepositoryAdapter extends AdapterOperations<AccountStatusReport,AccountStatusEntity,String,AccountStatusCrudRepository> implements AccountStatusRepository {


    public AccountStatusRepositoryAdapter(AccountStatusCrudRepository repository, ObjectMapper mapper) {
        super(repository,mapper,d -> mapper.mapBuilder(d,AccountStatusReport.AccountStatusReportBuilder.class).build());
    }

    @Override
    public List<AccountStatusReport> getReportAccountStatus(AccountStatusReportFilter filter) {

        return toList(repository.getAccountStatus(filter.getDateInit(),filter.getDateEnd(),filter.getName()));
    }
}
