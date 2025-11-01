# java-lotto-precourse
## 📝 구현 기능 목록

### 1. 입출력 기능

- [x]  구입 금액 입력 메시지를 출력한다.
- [x]  구입 금액을 입력받는다.
- [x]  구매한 로또의 개수를 출력한다.
- [x]  구매한 로또의 6가지 당첨 번호를 출력한다.
- [ ]  당첨 번호 입력 메시지를 출력한다.
- [ ]  당첨 번호를 입력받는다.
- [ ]  보너스 번호 입력 메시지를 출력한다.
- [ ]  보너스 번호를 입력받는다.
- [ ]  당첨 통계 메시지를 출력한다.
- [ ]  3~6개의 번호가 일치한 로또의 각각 개수를 출력한다.
- [ ]  총 수익률을 출력한다.
- [ ]  예외가 발생시, 에러 메시지를 출력한다.

### 2. 핵심 로직 기능

- [x]  1개의 로또는 중복되지 않는 6개의 숫자를 뽑는다.
- [x]  로또 한장을 1000원 기준으로 사용자의 구입 금액에 해당하는 로또 개수를 계산한다.
- [ ]  입력 받은 당첨 번호를 쉼표 기준으로 파싱하여 저장한다.
- [ ]  일치하는 로또 번호의 개수를 구한다.
- [ ]  5개의 번호가 일치한 경우 보너스 볼 번호가 일치한지 확인한다.
- [ ]  3~6개의 번호가 일치한 경우의 개수를 집계한다.
- [ ]  총 수익률을 계산한다.

### 3. 예외 처리 기능

- [ ]  입력받은 구입 금액이 빈 입력인 경우 IllegalArgumentException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 구입 금액이 1000원으로 나누어떨어지지 않는 경우 IllegalArgumentException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 구입 금액이 숫자가 아닌 경우 NumberFormatException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 구입 금액이 양수가 아닌 경우 IllegalArgumentException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 로또 번호가 빈 입력인 경우 IllegalArgumentException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 로또 번호가 1부터 45 사이의 숫자가 아닌 경우 IllegalArgumentException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 로또 번호가 쉼표를 기준으로 구분되어있지 않은 경우 IllegalArgumentException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 로또 번호를 쉼표를 기준으로 파싱한 결과가 6개가 아닌 경우 IllegalStateException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 로또 번호를 쉼표를 기준으로 파싱한 결과가 숫자가 아닌 경우 NumberFormatException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 로또 번호를 쉼표를 기준으로 파싱한 결과에 중복되는 숫자가 있는 경우 IllegalStateException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 보너스 번호가 빈 입력인 경우 IllegalArgumentException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 보너스 번호가 숫자가 아닌 경우 NumberFormatException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 보너스 번호가 1부터 45 사이의 숫자가 아닌 경우 IllegalArgumentException으로 에러 메시지를 출력한 후 다시 입력받는다.
- [ ]  입력받은 보너스 번호가 입력받은 로또 번호와 중복되는 숫자가 있는 경우 IllegalStateException으로 에러 메시지를 출력한 후 다시 입력받는다.

### 4. 기타

- [ ]  프로그램 종료시에 자원을 정리한다.

---

## 💌 커밋 컨벤션

Following convention : https://gist.github.com/stephenparish/9941e89d80e2bc58a153

```bash
# basic structure
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>

# <type>
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)

# <scope>
console - I/O
domain - 핵심 로직
validation - 유효성검사
test - 테스트코드 추가
```