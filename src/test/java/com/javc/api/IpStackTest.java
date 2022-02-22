package com.javc.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class IpStackTest extends BaseTest {

    @Test
    public void languageShouldBeEqualToBelarusian() {
        String languageName = ipStackService.getIpStack().getLocation().getLanguages().get(0).getName();
        Assertions.assertThat(languageName).as("Unexpectedly, language is wrong.").isEqualTo("Belarusian");
    }
}