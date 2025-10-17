package uk.gov.hmcts.reform.dev.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Service
public class BankHolidayService {

    private final Set<LocalDate> bankHolidayDates;

    public BankHolidayService() throws Exception {
        bankHolidayDates = new HashSet<>();
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("BankHoildays.json")) {
            JsonNode root = mapper.readTree(is);
            extractDates(root, "england-and-wales");
            extractDates(root, "scotland");
        }
    }

    private void extractDates(JsonNode root, String region) {
        JsonNode events = root.path(region).path("events");
        for (JsonNode event : events) {
            String dateStr = event.path("date").asText();
            bankHolidayDates.add(LocalDate.parse(dateStr));
        }
    }

    public boolean dateIsNotBankHoliday(LocalDateTime date) {
        return !bankHolidayDates.contains(date.toLocalDate());
    }
}
