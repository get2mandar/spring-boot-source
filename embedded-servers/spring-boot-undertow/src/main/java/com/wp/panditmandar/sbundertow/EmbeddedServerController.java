package com.wp.panditmandar.sbundertow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmbeddedServerController {

	@GetMapping("/web-server-name")
	public String getEmbeddedServerName() {
		return "Embedded Server Name is <b>UNDERTOW</b>";
	}

}
