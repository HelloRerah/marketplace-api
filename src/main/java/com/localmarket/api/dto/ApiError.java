
package com.localmarket.api.dto;

import java.time.Instant;
import java.util.Map;

public record ApiError(
        int status,
        String error,
        String messsage,
        Instant timestamp,
        Map<String, String> fieldErrors
        ) {

}
