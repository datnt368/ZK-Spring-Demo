package vn.test.zkoss.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.zkoss.lang.Library;
import org.zkoss.zk.ui.WebApps;

import javax.annotation.PostConstruct;

@Slf4j
@Profile("dev")
@Configuration
public class DevProfileConfig {

    @PostConstruct
    public void init() {
        log.info("------- Running on Dev Profile -------");
        //disable various caches to avoid server restarts
        Library.setProperty("org.zkoss.zk.ZUML.cache", "false");
        Library.setProperty("org.zkoss.zk.WPD.cache", "false");
        Library.setProperty("org.zkoss.zk.WCS.cache", "false");
        Library.setProperty("org.zkoss.web.classWebResource.cache", "false");
        Library.setProperty("org.zkoss.util.label.cache", "false");

        // enable non minified js
        WebApps.getCurrent().getConfiguration().setDebugJS(true);

        // enable for debugging MVVM commands and binding (very verbose)
        Library.setProperty("org.zkoss.bind.DebuggerFactory.enable", "false");
    }

}
