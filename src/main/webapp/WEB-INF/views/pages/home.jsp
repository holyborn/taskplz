<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>TaskPlz</title>
		<link rel="stylesheet" href="/resources/css/font.css" type="text/css" />
		<link rel="stylesheet" href="/resources/css/font-awesome.min.css">
		<link rel="stylesheet" href="/resources/css/home.css?v=201712291021" type="text/css" />
	</head>
	<body>
	<jsp:include page="/WEB-INF/views/pages/includer.jsp"/>
	<jsp:include page="/WEB-INF/views/pages/header.jsp"/>
	<section class="align-middle width-common" id="content-main">
		<div id="main-image">
			<dl>
				<dd>
					나에게 <span class="main-desc-point">딱 맞는 답</span>을 얻고 싶나요?<br /><br />
					지금 바로 질문해 보세요<br /><br /><br />
					<span class="main-desc-point">12 명</span>의 답변자가 기다리고 있습니다.
				</dd>
			</dl>
		</div>
		<div id="main-content">
			<dl id="main-content-search">
				<dd id="searchbox">
					<div>
						<input id="input-qst" type="text" placeholder="원하시는 질문의 내용이나  해쉬태그를 검색">
						<i id="btn-qst" class="button fa fa-search"></i>
					</div>
					or
					<div id="btn-qstdir" class="button">물어보기</div>
				</dd>
				<dd id="tabs">
					<ul>
						<li><input type="radio" name="tab" id="realtime" checked="checked"><label for="realtime" class="button">실시간 질문</label></li>
						<li><input type="radio" name="tab" id="percent"><label for="percent" class="button">승인 확률이 높은 질문</label></li>
						<li><input type="radio" name="tab" id="reword"><label for="reword" class="button">최대 리워드 질문</label></li>
						<li><input type="radio" name="tab" id="rank"><label for="rank" class="button">태플러 랭킹</label></li>
					</ul>	
				</dd>
				<dd>
				
				</dd>
			</dl>
			<dl id="realtime-content">
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">강아지가 치킨뼈를 먹었어요!!</span><span class="time-qst">2017년 11월 27일 20:10</span></p>
						<p class="desc-qst">토요일 오후 잠시 나간 사이에 쓰레기통을 다 뒤져서 비비큐 치킨 한 마리 분량의 닭뼈를 거의 다 먹은 것 같아요. 지금은 아무렇지 않아 보이긴 한데..</p>
						<p class="tags-qst"><span class="tag-qst button">#반려동물</span><span class="tag-qst button">#강아지</span><span class="tag-qst button">#생활</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">5,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-1</span></p>
						<p><label>조 회 수</label><span class="read">4</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">골키퍼 장갑 냄새 빼기</span><span class="time-qst">2017년 11월 27일 20:13</span></p>
						<p class="desc-qst">키퍼 장갑을 비올 때 한번 썼더니 냄새가 너무 심하게 나서 세척을 하려는데 프리워시를 살 수 없어서 따뜻한물에다가 그냥 담궈놓아...</p>
						<p class="tags-qst"><span class="tag-qst button">#스포츠</span><span class="tag-qst button">#축구</span><span class="tag-qst button">#구기종목</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">3,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-7</span></p>
						<p><label>조 회 수</label><span class="read">6</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">아빠한테 미안해요</span><span class="time-qst">2017년 11월 27일 20:17</span></p>
						<p class="desc-qst">오늘 아빠가 저랑  같이 목욕탕 가자고 했는데 제가 거절했어요... 그런데 몇시간 뒤에 친구가 목욕탕 가자고 연락이 왔는데 몰래 나가다가 들켰답니다!!</p>
						<p class="tags-qst"><span class="tag-qst button">#생활</span><span class="tag-qst button">#가정</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">---</span></p>
						<p><label>마감시간</label><span class="d-day">D-7</span></p>
						<p><label>조 회 수</label><span class="read">12</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">2</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">애니메이션 만들 때 가장 유용한 앱</span><span class="time-qst">2017년 11월 27일 21:00</span></p>
						<p class="desc-qst">애니메이션 만들 때 가장 유용한 앱이 뭔가요? 아시면 줴~발~ 답장해주세욥</p>
						<p class="tags-qst"><span class="tag-qst button">#컴퓨터</span><span class="tag-qst button">#스마트폰</span><span class="tag-qst button">#어플</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">1,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-3</span></p>
						<p><label>조 회 수</label><span class="read">5</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				<!-- 
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst"></span><span class="time-qst"></span></p>
						<p class="desc-qst"></p>
						<p class="tags-qst"><span class="tag-qst button">#</span><span class="tag-qst button">#</span><span class="tag-qst button">#</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword"></span></p>
						<p><label>마감시간</label><span class="d-day">D-</span></p>
						<p><label>조 회 수</label><span class="read"></span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				-->
			</dl>
			<dl id="percent-content">
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">애니메이션 만들 때 가장 유용한 앱</span><span class="time-qst">2017년 11월 27일 21:00</span></p>
						<p class="desc-qst">애니메이션 만들 때 가장 유용한 앱이 뭔가요? 아시면 줴~발~ 답장해주세욥</p>
						<p class="tags-qst"><span class="tag-qst button">#컴퓨터</span><span class="tag-qst button">#스마트폰</span><span class="tag-qst button">#어플</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">1,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-3</span></p>
						<p><label>조 회 수</label><span class="read">5</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">골키퍼 장갑 냄새 빼기</span><span class="time-qst">2017년 11월 27일 20:13</span></p>
						<p class="desc-qst">키퍼 장갑을 비올 때 한번 썼더니 냄새가 너무 심하게 나서 세척을 하려는데 프리워시를 살 수 없어서 따뜻한물에다가 그냥 담궈놓아...</p>
						<p class="tags-qst"><span class="tag-qst button">#스포츠</span><span class="tag-qst button">#축구</span><span class="tag-qst button">#구기종목</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">3,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-7</span></p>
						<p><label>조 회 수</label><span class="read">6</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">아빠한테 미안해요</span><span class="time-qst">2017년 11월 27일 20:17</span></p>
						<p class="desc-qst">오늘 아빠가 저랑  같이 목욕탕 가자고 했는데 제가 거절했어요... 그런데 몇시간 뒤에 친구가 목욕탕 가자고 연락이 왔는데 몰래 나가다가 들켰답니다!!</p>
						<p class="tags-qst"><span class="tag-qst button">#생활</span><span class="tag-qst button">#가정</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">---</span></p>
						<p><label>마감시간</label><span class="d-day">D-7</span></p>
						<p><label>조 회 수</label><span class="read">12</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">2</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">강아지가 치킨뼈를 먹었어요!!</span><span class="time-qst">2017년 11월 27일 20:10</span></p>
						<p class="desc-qst">토요일 오후 잠시 나간 사이에 쓰레기통을 다 뒤져서 비비큐 치킨 한 마리 분량의 닭뼈를 거의 다 먹은 것 같아요. 지금은 아무렇지 않아 보이긴 한데..</p>
						<p class="tags-qst"><span class="tag-qst button">#반려동물</span><span class="tag-qst button">#강아지</span><span class="tag-qst button">#생활</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">5,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-1</span></p>
						<p><label>조 회 수</label><span class="read">4</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
			</dl>
			<dl id="reword-content">
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">강아지가 치킨뼈를 먹었어요!!</span><span class="time-qst">2017년 11월 27일 20:10</span></p>
						<p class="desc-qst">토요일 오후 잠시 나간 사이에 쓰레기통을 다 뒤져서 비비큐 치킨 한 마리 분량의 닭뼈를 거의 다 먹은 것 같아요. 지금은 아무렇지 않아 보이긴 한데..</p>
						<p class="tags-qst"><span class="tag-qst button">#반려동물</span><span class="tag-qst button">#강아지</span><span class="tag-qst button">#생활</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">5,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-1</span></p>
						<p><label>조 회 수</label><span class="read">4</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">골키퍼 장갑 냄새 빼기</span><span class="time-qst">2017년 11월 27일 20:13</span></p>
						<p class="desc-qst">키퍼 장갑을 비올 때 한번 썼더니 냄새가 너무 심하게 나서 세척을 하려는데 프리워시를 살 수 없어서 따뜻한물에다가 그냥 담궈놓아...</p>
						<p class="tags-qst"><span class="tag-qst button">#스포츠</span><span class="tag-qst button">#축구</span><span class="tag-qst button">#구기종목</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">3,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-7</span></p>
						<p><label>조 회 수</label><span class="read">6</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">애니메이션 만들 때 가장 유용한 앱</span><span class="time-qst">2017년 11월 27일 21:00</span></p>
						<p class="desc-qst">애니메이션 만들 때 가장 유용한 앱이 뭔가요? 아시면 줴~발~ 답장해주세욥</p>
						<p class="tags-qst"><span class="tag-qst button">#컴퓨터</span><span class="tag-qst button">#스마트폰</span><span class="tag-qst button">#어플</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">1,000</span></p>
						<p><label>마감시간</label><span class="d-day">D-3</span></p>
						<p><label>조 회 수</label><span class="read">5</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">0</span></p>
					</div>
				</dd>
				<dd class="box-qst button">
					<div class="txt-qst">
						<p><span class="q">Q. </span><span class="title-qst">아빠한테 미안해요</span><span class="time-qst">2017년 11월 27일 20:17</span></p>
						<p class="desc-qst">오늘 아빠가 저랑  같이 목욕탕 가자고 했는데 제가 거절했어요... 그런데 몇시간 뒤에 친구가 목욕탕 가자고 연락이 왔는데 몰래 나가다가 들켰답니다!!</p>
						<p class="tags-qst"><span class="tag-qst button">#생활</span><span class="tag-qst button">#가정</span></p>
					</div>
					<div class="nums-qst">
						<p class="f-reword">￦ <span class="reword">---</span></p>
						<p><label>마감시간</label><span class="d-day">D-7</span></p>
						<p><label>조 회 수</label><span class="read">12</span></p>
						<p class="box-mark"><label><img src="/resources/images/unmarked.png"></label><span class="marked">2</span></p>
					</div>
				</dd>
			</dl>
			<dl id="rank-content">
				<dd class="box-rank button">
					<div class="rank-pos">1위</div>
					<div class="img-ranker" style="background-image:url('/resources/images/rank1.jpg');background-position:50%;background-size:cover">
						
					</div>
					<div class="box-info-ranker">
						<p class="nick-ranker">Doobu</p>
						<p class="c-gray"><label>답변 수</label><span class="amt-rep">14</span></p>
						<p class="c-taskplz"><label>후기</label><span class="amt-rvw">8</span></p>
					</div>
				</dd>
				<dd class="box-rank button">
					<div class="rank-pos">2위</div>
					<div class="img-ranker" style="background-image:url('/resources/images/rank2.jpg');background-position:50%;background-size:cover">
						
					</div>
					<div class="box-info-ranker">
						<p class="nick-ranker">Daniel</p>
						<p class="c-gray"><label>답변 수</label><span class="amt-rep">12</span></p>
						<p class="c-taskplz"><label>후기</label><span class="amt-rvw">8</span></p>
					</div>
				</dd>
				<dd class="box-rank button">
					<div class="rank-pos">3위</div>
					<div class="img-ranker" style="background-image:url('/resources/images/rank3.jpg');background-position:50%;background-size:cover">
						
					</div>
					<div class="box-info-ranker">
						<p class="nick-ranker">BulPro</p>
						<p class="c-gray"><label>답변 수</label><span class="amt-rep">16</span></p>
						<p class="c-taskplz"><label>후기</label><span class="amt-rvw">6</span></p>
					</div>
				</dd>
				<dd class="box-rank button">
					<div class="rank-pos">4위</div>
					<div class="img-ranker" style="background-image:url('/resources/images/rank4.jpg');background-position:50%;background-size:cover">
						
					</div>
					<div class="box-info-ranker">
						<p class="nick-ranker">Gamjatang</p>
						<p class="c-gray"><label>답변 수</label><span class="amt-rep">10</span></p>
						<p class="c-taskplz"><label>후기</label><span class="amt-rvw">5</span></p>
					</div>
				</dd>
				<dd class="box-rank button">
					<div class="rank-pos">5위</div>
					<div class="img-ranker" style="background-image:url('/resources/images/rank5.jpg');background-position:50%;background-size:cover">
						
					</div>
					<div class="box-info-ranker">
						<p class="nick-ranker">Irene</p>
						<p class="c-gray"><label>답변 수</label><span class="amt-rep">6</span></p>
						<p class="c-taskplz"><label>후기</label><span class="amt-rvw">3</span></p>
					</div>
				</dd>
				<dd class="box-rank button">
					<div class="rank-pos">6위</div>
					<div class="img-ranker" style="background-image:url('/resources/images/rank6.jpg');background-position:50%;background-size:cover">
						
					</div>
					<div class="box-info-ranker">
						<p class="nick-ranker">멍죠</p>
						<p class="c-gray"><label>답변 수</label><span class="amt-rep">5</span></p>
						<p class="c-taskplz"><label>후기</label><span class="amt-rvw">3</span></p>
					</div>
				</dd>
			</dl>
		</div>
		<div id="tags">
			<h3># 추천 태그</h3>
			<div id="box-tags">
				<dl class="box">
					<dd class="tag button">#스포츠/레져</dd>
					<dd class="amount">질문수 14</dd>
				</dl>
				<dl class="box">
					<dd class="tag button">#영어번역</dd>
					<dd class="amount">질문수 13</dd>
				</dl>
				<dl class="box">
					<dd class="tag button">#영화</dd>
					<dd class="amount">질문수 10</dd>
				</dl>
				<dl class="box">
					<dd class="tag button">#강아지</dd>
					<dd class="amount">질문수 7</dd>
				</dl>
				<dl class="box">
					<dd class="tag button">#고용/노동</dd>
					<dd class="amount">질문수 6</dd>
				</dl>
				<dl class="box">
					<dd class="tag button">#아이폰</dd>
					<dd class="amount">질문수 3</dd>
				</dl>
			</div>
		</div>
	</section>
	<script src="/resources/js/home.js?v=201712291021"></script>
	</body>
</html>
