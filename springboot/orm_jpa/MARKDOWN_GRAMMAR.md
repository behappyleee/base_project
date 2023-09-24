# MarkDown 문법 정리

<!-- 헤더 마크다운 문법 -->

# This is an H1
## This is an H2
### This is an H3
#### This is an H4
##### This is an H5
###### This is an H6

<!-- 수평선 -->

* * *
***
*****
- - -
-------------------

<!-- 줄 바꿈 -->
줄<br>바꿈

<!-- 강조 하기 -->
_This will also be italic_

**This will also be bold**

~~This is canceled~~

_You **can** ~~combine~~ them_

<!-- (인용 -->
> I’ve always been more interested in the future than in the past.    
> This is a first blockquote.
> > This is a second blockquote.
> > > This is a third blockquote.

<!-- (List 목록 -->
* 머리
    * 코
        * 입

+ 머리
    + 코
        + 입
            * 입

- 머리
- 코
- 입
  Copy

<!-- (Ordered lists 순서가 있는 목록) -->

1. 머리
2. 다리
3. 뚝배기
5. 팔 <!-- 5번을 썻는데도 4번으로 표시된다. -->

<!-- List 안에 List 정의 (Tab 과 함께 1번 서부터 나열) -->
1. 리스트 1번
    1. 리스트 1-1번
2. 리스트 2번
3. 리스트 3번
    1. 리스트 3-1번 <!-- 리스트 안 리스트를 사용하려면 tab과 함꼐 숫자 1번 서부터 -->
    2. 리스트 3-2번

<!-- 혼합 List -->
1. 머리
    * 머리카락
    * 뚝배기
        + 털
2. 다리
    - 다리털
    - 발가락
        1. 허벅지


<!-- 특수문자 표현 시 표시 될 문자 앞에 ( \ )삽입 -->
* 특수문자 출력안됨
- 특수문자 출력안됨

\* 특수 문자 출력

\- 특수 문자 출력

<!-- Links (Anchor) 링크 -->
[Google](http://www.google.com "구글")

[Naver](http://www.naver.com "네이버")

[Github](http://www.github.com "깃허브")

<!-- 테이블 생성 -->
헤더1|헤더2|헤더3|헤더4
---|---|---|---
셀1|셀2|셀3|셀4
셀5|셀6|셀7|셀8
셀9|셀10|셀11|셀12

<!-- 테이블 정렬 -->
헤더1|헤더2|헤더3
:---|:---:|---:
Left|Center|Right
1|2|3
4|5|6
7|8|9



