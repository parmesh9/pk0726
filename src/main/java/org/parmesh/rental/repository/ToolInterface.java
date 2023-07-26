package org.parmesh.rental.repository;

import org.parmesh.rental.entity.Tool;

public interface ToolInterface {
    Tool getToolByCode(String toolCode);
}
