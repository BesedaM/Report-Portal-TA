package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.ui.page.DashboardsPage;

import static org.assertj.core.api.Assertions.*;

public class DashboardsUIValidation {

    public static void validateDashboardsPage(){
        assertThat(new DashboardsPage().getHeader().getText()).isEqualTo("ALL DASHBOARDS");
        assertThat(new DashboardsPage().getMyDashboardsHeader().getText()).isEqualTo("MY DASHBOARDS");
        assertThat(new DashboardsPage().getSharedDashboardsHeader().getText()).isEqualTo("SHARED DASHBOARDS");
        assertThat(new DashboardsPage().getDashboardList().size()).isGreaterThan(0);
    }
}
