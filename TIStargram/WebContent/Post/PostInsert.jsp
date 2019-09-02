<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(function() {
		$("#tag").keyup(function(e) {
			if (e.keyCode == 13 || e.keyCode == 32) {
				tagEvent();
			}
		})

		function tagEvent() {
			var txt = $("#tag").val();
			var tags = [];
			txt = txt.replace(/#[^#\s,;]+/gm, function(tag) {
				tags.push(tag);
			});
			txt = txt.replace(/undefined/gi, "");
			$("#tag").val("");
			$("#tag").val(txt);
			$("#tagArea").append(tags.join(" ") + " ");
			$("#htag").val($("#tagArea").text());
			$("#tag").focus();
			if (!($("#tagArea").is(":visible"))) {
				$("#tagArea").show();
			}
		}
		$("#form").submit(function(){
			tagEvent();
			$(this).submit();
		})
		
	})
</script>


<div class='modal-dialog modal-dialog-centered modal-xl'>
	<div class='modal-body'>
		<div class="container" style="background-color: white;">
			<form role="form" id="form" name="frm" method="post"
				action="${pageContext.request.contextPath }/user/fileUpLoad.do"
				enctype="multipart/form-data">
				<!-- 업로드 처리 -->

				<textarea name="text-contents" id="tag" class="form-control"></textarea>
				<input type="hidden" name="tags" id="htag">
				<div hidden="hidden" id="tagArea"></div>
				<br>
				<!-- textarea -->

				<input type="file" id="input_imgs1" name="filename1"
					class="form-control" /> <br> <input type="file"
					id="input_imgs2" name="filename2" class="form-control" /> <br>
				<input type="file" id="input_imgs3" name="filename3"
					class="form-control" /> <br>

				<div class="imgs_wrap" style="background-color: blue;"></div>
				<div>
					<a href="javascript:frm.submit()">업로드</a>
				</div>
			</form>
		</div>
	</div>
</div>