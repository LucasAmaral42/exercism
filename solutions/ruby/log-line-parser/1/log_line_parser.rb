class LogLineParser
  def initialize(line)
    @line = line
  end

  def message
    @line.match(/\]: (.+)/)[1].strip
  end

  def log_level
    @line.match(/\[(.+)\]/)[1].strip.downcase
  end

  def reformat
    "#{message} (#{log_level})"
  end
end
