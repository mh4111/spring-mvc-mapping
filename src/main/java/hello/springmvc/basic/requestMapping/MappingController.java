package hello.springmvc.basic.requestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "OK";
    }

    /*
    * method 특징 HTTP 메서드 요청만 허용
    * GET, HEAD, POST, PUT, PATCH, DELETE
    */

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "mappingGetV1";
    }

    /*
    * 편리한 축약 annotation
    * @GetMapping
    * @PostMapping
    * @PutMapping
    * @DeleteMapping
    * @PatchMapping
    * */

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "mappingGetV2";
    }

    /*
    * PathVariable 사용
    * 변수명이 같으면 생량 가능
    *
    * @PathVariable("userId") String userid -> @PathVariable userId
    * /mapping/userA*/

    //PathVariable(경로변수) 사용
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId={}", data);
        return "mappingPath";
    }

    //pathVariable 다중 사용
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mapping userId={}, orderId={}", userId, orderId);
        return "mappingPath";
    }

    /*
    * 파라미터로 추가 매핑
    * params="mode",
    * params-"!mode"
    * params="mode=debug"
    * params="mode!=debug"
    * params={"mode=debug", "data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "mappingParam";
    }

    /*
    * 특정 헤더로 추가 매핑
    * headers="mode"
    * headers="!mode"
    * headers="mode=debug"
    * headers="mode!=debug"
    */
    @GetMapping(value = "mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "mappingHeader";
    }

    /*Content-Type 헤더 기반 추가 매핑 Media Type
    * consumes="application/json"
    * consumes="!application/sjon"
    * consumes="application/*"
    * consumes="*\/*"
    * MediaType.APPLICATION_JSON_VALUE
    * */
    //미디어타입 매핑
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "mappingConsumes";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "mappingProduces";
    }
}
