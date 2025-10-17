package uk.gov.hmcts.reform.dev.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;


@ExtendWith(MockitoExtension.class)
class BankHolidayServiceTest {

    @InjectMocks
    private BankHolidayService bankHolidayService;

    @Test
    void getBankHolidayDates_returnsDates() {
        // Test implementation to verify bank holiday dates are loaded correctly
        Set<LocalDate> dates = bankHolidayService.getBankHolidayDates();
        assertFalse(dates.isEmpty());
    }

}
