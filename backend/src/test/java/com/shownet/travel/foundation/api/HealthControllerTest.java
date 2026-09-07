package com.shownet.travel.foundation.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class HealthControllerTest {

    @Test
    void returnsPublicHealthResponse() {
        var response = new HealthController().health();

        assertEquals("UP", response.status());
        assertEquals("shownet-travel-backend", response.service());
        assertNotNull(response.timestamp());
    }
}
