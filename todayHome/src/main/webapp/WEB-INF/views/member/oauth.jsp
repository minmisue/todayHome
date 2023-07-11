<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/axios@1.1.2/dist/axios.min.js"></script>
<title>Insert title here</title>
</head>
<body>
wait..
</body>
<script>
	window.onload = () => {
		const urlParams = new URLSearchParams(window.location.search);
		const kakaoCode = urlParams.get('code');
		
		const tokenUrl = 'https://kauth.kakao.com/oauth/token';
		
		axios.post(
				tokenUrl,
				{},
				{
					headers: {
						'Content-type': 'application/x-www-form-urlencoded;charset=utf-8'
					},
					params: {
						grant_type: 'authorization_code',
						client_id: '3ebf8bbbb7b91d2e8e34c1ae7d68f0db',
						redirect_uri: 'http://localhost:9090/app/oauth',
						code: kakaoCode
					}
				}
		).then(({data}) => {
			const accessToken = data.access_token;

			return axios.post(
					'/app/login/kakao',
					{},
					{
						headers: {
							Authorization: 'bearer ' + accessToken
						}
					}
			);
		}).then(() => {
			
		});
	}
</script>
</html>