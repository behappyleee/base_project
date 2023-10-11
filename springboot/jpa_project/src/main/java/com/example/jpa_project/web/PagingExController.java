package com.example.jpa_project.web;

import com.example.jpa_project.domain.Member;
import com.example.jpa_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class PagingExController {
    
    // 페이징과 정렬 예제

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/member/paging", method = RequestMethod.GET)
    public List<Member> list(Pageable pageable, Model model) {

        // Pageable 은 다음 요청 파라미터 정보로 만들어 진다.
        // Pageable 은 실제 인터페이스이다 실제는 org.springframework.data.domain.PageRequest 객체가 생성이 된다.

        // page : 현재 페이지 0 부터 시작
        // size : 한 페이지에 노출할 데이터 건수
        // sort : 정렬을 정의 (정렬 속성을 정의 ASC | DESC)

        // -> 이런 식으로 파라미터를 넘겨준다.
        // ex) /members?page=0&size=20&sort=name, desc&sort=address.city

       // paging 정렬 예제
       Page<Member> members = memberService.findMembers(pageable);

       // getContent() 메서드를 이용하여 List<Member> 데이터를 꺼내서 조회를 한다.
       List<Member> membersList = members.getContent();

        return membersList;
    }
    
}
