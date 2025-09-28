# HW_1: Dispatcher Servlet의 작동방식을 이해하고 Logging Interceptor 테스트 해보기

[Dispatcher Servlet 내용 정리](https://tangy-piper-b2d.notion.site/Dispatcher-Controller-273b10853ebd803f92d3f3ba61cf31de?source=copy_link)

## 단계별 설명 
```agsl
1. LoggingInterceptor 구체화
2. WebConfig에 해당 인터셉터 삽입
3. Controller에서 테스트
```

## Controller 설명
```agsl
@RestController
@RequestMapping("/hw1")
public class Controller {
    @GetMapping
    public String measureFiveSeconds(){
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "초");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return "hello";
    }
}
```
- 해당 url진입 시 5초를 세는 프로그램
- 5초 이후에 "hello"를 리턴한다.
- Logging 프로그램을 통해 해당작업에 몇초가 소요되는지 확인 가능
```agsl
[LOGGING] Completed URL: /hw1 | Time Taken: 5027ms
```

