package hello.springmvc.basic.requestmapping;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * 회원 목록 조회
     * GET /mapping/users (mapping 는 다른 강의와 구분하도록 사용)
     */
    @GetMapping
    public String users() {
        return "get users";
    }
    /**
     * 회원 등록
     * POST /mapping/users
     */
    @PostMapping
    public String addUser() {
        return "post user";
    }
    /**
     * 회원 조회
     * GET /mapping/users/{userId}
     */
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId=" + userId;
    }
    /**
     * 회원 수정
     * PATCH /mapping/users/{userId}
     */
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {

        return "update userId=" + userId;
    }
    /**
     * 회원삭제
     * DELETE /mapping/users/{userId}
     */
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId=" + userId;
    }
}