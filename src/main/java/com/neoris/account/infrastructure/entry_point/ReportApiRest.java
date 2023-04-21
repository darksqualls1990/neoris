package com.neoris.account.infrastructure.entry_point;

import com.neoris.account.domain.model.report.AccountStatusReportFilter;
import com.neoris.account.domain.usecase.report.ReportUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.neoris.account.infrastructure.util.JSendResponse.success;

@RestController
@RequestMapping("/report")
public class ReportApiRest {

    @Autowired
    private ReportUseCase reportUseCase;

    @GetMapping()
    public ResponseEntity<Object> generateReport(@RequestParam("dateInit") String dateInit,
                                                 @RequestParam("dateEnd") String dateEnd,
                                                 @RequestParam("name") String name) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        AccountStatusReportFilter filter=AccountStatusReportFilter.builder()
                .dateInit(LocalDate.parse(dateInit, formatter))
                .dateEnd(LocalDate.parse(dateEnd,formatter))
                .name(name).build();
        return ResponseEntity.ok(success("report", reportUseCase.getReport(filter)));
    }

}
