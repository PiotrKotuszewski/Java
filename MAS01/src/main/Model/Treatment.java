package main.Model;

import java.util.ArrayList;
import java.util.List;

public class Treatment {
    private String materialConsumption;

    private List<Tool> toolList = new ArrayList<>();

    public Treatment(String materialConsumption) {
        this.materialConsumption = materialConsumption;
    }

    public Tool createTool(String toolName, double sterilizationTime){
        Tool tool = new Tool(toolName, sterilizationTime);
        toolList.add(tool);

        return tool;
    }
    @Override
    public String toString() {
        return "Treatment{" +
                "materialConsumption='" + materialConsumption + '\'' +
                '}';
    }

    public class Tool{
        private String toolName;
        private double sterilizationTime;

        public Tool(String toolName, double sterilizationTime) {
            this.toolName = toolName;
            this.sterilizationTime = sterilizationTime;
        }

        @Override
        public String toString() {
            return "Tool{" +
                    "toolName='" + toolName + '\'' +
                    ", sterilizationTime=" + sterilizationTime +
                    '}';
        }
    }
}
