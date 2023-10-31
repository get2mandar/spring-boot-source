package com.wp.panditmandar.archunit;

import java.math.BigDecimal;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchUnitCommonTest {

	@ArchTest
	public static final ArchRule bigDecimalRule = noClasses().should().callConstructor(BigDecimal.class, double.class);

}