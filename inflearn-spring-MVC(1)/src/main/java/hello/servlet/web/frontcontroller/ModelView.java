package hello.servlet.web.frontcontroller;
import java.util.HashMap;
import java.util.Map;

/*
전에는 HttpServletRequest, Response 을 통해 데이터를 저장했지만
모델링을 통해 데이터를 저장하는 구조로 변경
 */
public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return viewName;
    }
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    public Map<String, Object> getModel() {
        return model;
    }
    public void setModel(Map<String, Object> model) {
        this.model = model;
    } }