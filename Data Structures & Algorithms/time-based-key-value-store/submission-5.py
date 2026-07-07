class TimeMap:

    def __init__(self):
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append([value, timestamp])


    def get(self, key: str, timestamp: int) -> str:
        list = self.store.get(key, [])
        l, r = 0, len(list) - 1
 
        string = "";
        while l <= r:
            #doing / does float division so you need to do integer division with //
            m = l + (r - l) // 2;
            if timestamp >= list[m][1]:
                string = list[m][0]
                l = m + 1
            elif timestamp < list[m][1]:
                r = m - 1
        return string