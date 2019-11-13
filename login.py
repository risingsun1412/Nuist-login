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
    print('[*]正在发送登陆请求(第%d次)......'%times)
    
    response = post(url, data = pyload)
    if response.status_code == 200:
        print('[*]请求发送成功！！')
    else:
        print('[!]请求发送失败，请检查网络状态！！！')
    test = get('http://baidu.com')
    if (test.text.find("南京信息工程大学信息化建设与管理处") == -1):
        print('[*]登陆成功!')
        return
    else:
        print('[!]网络认证失败!')
        sleep(1)
        print('[*]尝试重新登陆!')
        main(username, domain, password, times + 1)
        
        
    
if __name__ == "__main__":
    main('', 'ChinaNet', '', 1)# 账号，运营商，密码(base64)
    