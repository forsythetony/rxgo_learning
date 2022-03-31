package com.example.service;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Singleton
public class OrgoneService {

    private final Logger logger = LoggerFactory.getLogger(OrgoneService.class);
    private final Random random = new Random();

    private final static int ORGONE_UPPER_LIMIT = 10000;
    private final static int WAIT_UPPER_LIMIT = 10;

    public int calculateTotalOrgonesForUser(String userId) {

        //  We don't really care about the user ID so just chuck it
        //  out the window 👉🪟
        logger.info(
                "Chucking user with ID {} out the window because it doesn't matter..." +
                " The universe 🪐 will guide us...",
                userId
        );

        //  Wait between 1 and 10 seconds so this sucker things we're
        //  doing something 😎
        waitRandomTime();

        return getRandomOrgoneCount();
    }

    private int getRandomOrgoneCount() {
        return random.nextInt(ORGONE_UPPER_LIMIT);
    }

    private void waitRandomTime() {
        long secondsToSleep = random.nextInt(WAIT_UPPER_LIMIT - 1) + 1;

        logger.info("I'm going to wait {} seconds", secondsToSleep);

        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException interruptedException) {
            logger.warn("My sleep was interrupted {}", interruptedException.getMessage());
        }
    }
}
