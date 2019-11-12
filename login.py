from requests import get
from requests import post
from time import sleep

def main(username, domain, password, times):
    url = 'http://a.nuist.edu.cn/index.php/index/login'
    pyload = {
        'username': username,
        'domain': domain,
        'password': password,
        'enablemacauth': '0',
    }
    print('正在发送登陆请求(第%d次)......'%times)
    try:
        response = post(url, data = pyload)
        if response.status_code == 200:
            print('请求发送成功！！')
        else:
            print('请求发送失败，请检查网络状态！！！')
        test = get('https://www.baidu.com')
        if test.status_code == 200:
            print('登陆成功！！')
            return
        else:
            print(test.status_code)
    except:
        print('登陆失败！！！')
        sleep(0.2)
        print('尝试重新登陆!')
        main(username, domain, password, times + 1)
    
if __name__ == "__main__":
    main('', 'ChinaNet', '', 1)# 账号，运营商，密码(base64)
    