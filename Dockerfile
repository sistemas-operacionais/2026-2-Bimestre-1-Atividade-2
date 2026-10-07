FROM nickblah/lua:5.4-luarocks

RUN apt-get update && apt-get install -y \
    git \
    build-essential \
    libc6-dev

RUN luarocks install lanes

WORKDIR /app

COPY . .

CMD ["lua", "src/lua/thread-1.lua"]